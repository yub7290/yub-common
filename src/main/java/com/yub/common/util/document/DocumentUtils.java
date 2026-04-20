package com.yub.common.util.document;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: 文档工具类（基于 EasyExcel）
 * @Version: 1.0.0
 */
public final class DocumentUtils {

    /** 私有构造器，禁止实例化 */
    private DocumentUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    /**
     * 读取 Excel 文件（根据类型自动匹配）
     *
     * @param filePath 文件路径
     * @param clazz 映射类
     * @param <T> 数据类型
     * @return 数据列表
     */
    public static <T> List<T> readExcel(String filePath, Class<T> clazz) {
        return EasyExcel.read(filePath).head(clazz).sheet().doReadSync();
    }

    /**
     * 读取 Excel 文件（流）
     *
     * @param inputStream 输入流
     * @param clazz 映射类
     * @param <T> 数据类型
     * @return 数据列表
     */
    public static <T> List<T> readExcel(InputStream inputStream, Class<T> clazz) {
        return EasyExcel.read(inputStream).head(clazz).sheet().doReadSync();
    }

    /**
     * 写入 Excel 文件
     *
     * @param filePath 文件路径
     * @param clazz 映射类
     * @param data 数据列表
     * @param <T> 数据类型
     */
    public static <T> void writeExcel(String filePath, Class<T> clazz, List<T> data) {
        EasyExcel.write(filePath, clazz)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("Sheet1")
                .doWrite(data);
    }

    /**
     * 写入 Excel 文件（流）
     *
     * @param outputStream 输出流
     * @param clazz 映射类
     * @param data 数据列表
     * @param <T> 数据类型
     */
    public static <T> void writeExcel(OutputStream outputStream, Class<T> clazz, List<T> data) {
        EasyExcel.write(outputStream, clazz)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .sheet("Sheet1")
                .doWrite(data);
    }
}