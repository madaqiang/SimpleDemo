package com.mdq.simpletest.demo.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Test7 {


    public static void main(String[] args) {
        int[] elements = {1,2,3,4,5,6,7};
        int newLength = (elements.length*3>>>1)+1;//0001 0101--> 0000 1010 + 1; // 0000 0101
        System.out.println(newLength);

    }
}
