package com.hogan.budget.util;

import android.util.Log;

import com.hogan.budget.base.BaseResource;
import com.hogan.budget.base.BaseType;
import com.hogan.budget.base.global.GlobalConstants;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hogan on 9/3/2016.
 * 解析XML资源文件
 */
public class XMLParse {

    public static BaseResource parse(InputStream in, BaseType xmlType, Class beanClass) {
        XmlPullParser xpp = null;
        XmlPullParserFactory xmlPullParserFactory = null;
        BaseResource bean = null;
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xpp = xmlPullParserFactory.newPullParser();
            xpp.setInput(in, "utf-8");
            int event = xpp.getEventType();
            boolean firstEqualFlag = true;
            while (event != XmlPullParser.END_DOCUMENT) {
                String name = xpp.getName();
                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (!firstEqualFlag) {
                            xpp.next();
                            ReflectUtil.xmlToBeanBySetMethod(bean, xpp.getText(), name);
                        } else {
                            if (name.equals(xmlType.getDescription())) {
                                firstEqualFlag = false;
                                Log.i(GlobalConstants.LOG_PARSE_XML, "Start Parsing " + name);
                                bean = (BaseResource) beanClass.newInstance();
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (name.equals(xmlType.getDescription())) {
                            Log.i(GlobalConstants.LOG_PARSE_XML, "End Parsing " + name);
                        }
                        break;
                }
                event = xpp.next();
            }
        } catch (XmlPullParserException e) {
            Log.e(GlobalConstants.LOG_PARSE_XML, "xpp object failed!");
        } catch (IOException e) {
            Log.e(GlobalConstants.LOG_PARSE_XML, "xpp next() failed!");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}

