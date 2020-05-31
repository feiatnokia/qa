package com.tututu.qa.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Yu QiLin
 * @description data provider helper
 * @createTime 2020年05月31日 16:03:00
 */
@Slf4j
public class DataHelper extends AbstractTestNGSpringContextTests {

    private String metaDataPath = "./src/test/resources/data/";

    private int totalRows = 0;// 总行数
    private int totalCells = 0;// 总列数


    @DataProvider(name = "excel")
    public Iterator<Object[]> dataMethod(Method method) {
        DataFile d = method.getAnnotation(DataFile.class);
        List<Object> items = new ArrayList<>();
        List<List<String>> rows = read(d.path(), d.sheet());
        if (rows != null || rows.size() > 0) {
            int size = rows.get(0).size();
            for (int i = 1; i < rows.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                for (int j = 0; j < size; j++) {
                    map.put(rows.get(0).get(j), rows.get(i).get(j));
                }
                items.add(map);
            }
        }
        List<Object[]> results = new ArrayList<>();
        for (Object item : items) {
            results.add(new Object[]{item});
        }
        return results.iterator();
    }

    //yaml文件
    @DataProvider(name = "yaml")
    public Iterator<Object[]> dataMethodYaml(Method m) {
        DataFile d = m.getAnnotation(DataFile.class);
        InputStream in = ClassLoader.getSystemResourceAsStream(d.path());
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.loadAs(in, Map.class);
        List<Map<String, String>> data = (List<Map<String, String>>) map.get(d.key());
        List<Object[]> results = new ArrayList<>();
        for (Object u : data) {
            results.add(new Object[]{u});
        }
        return results.iterator();
    }

    //csv文件读取
    @DataProvider(name = "csv")
    public Iterator<Object[]> dataMethod1(Method m) {
        DataFile d = m.getAnnotation(DataFile.class);
        File inFile = new File(metaDataPath + d.path());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            boolean sign = false;       //First Line ignore
            List<Object> item = new ArrayList<Object>();
            List<String> list = new ArrayList<>();
            String[] title = new String[0];
            while (reader.ready()) {
                String line = reader.readLine();
                String[] string = line.split(",");
                if (!sign) {
                    sign = true;
                    title = string;
                } else {
                    Map<String, Object> map = new HashMap<>();
                    if (string != null && string.length > 0 && title != null && title.length > 0) {
                        for (int j = 0; j < title.length; j++) {
                            map.put(specialUnicode(title[j]), string[j]);
                            //map.put(title[j], string[j]);
                        }
                        item.add(map);
                    }
                }
            }
            reader.close();
            List<Object[]> results = new ArrayList<Object[]>();
            for (Object u : item) {
                //做一个形式转换
                results.add(new Object[]{u});
            }
            return results.iterator();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<List<String>> read(String fileName, String sheetName) {
        List<List<String>> maps = new ArrayList<>();
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$"))
            return maps;
        try {
            InputStream inputStream = new FileInputStream(metaDataPath + fileName);
            Workbook wb = WorkbookFactory.create(inputStream);
            maps = read(wb, sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }


    private List<List<String>> read(Workbook wb, String sheetName) {
        List<List<String>> maps = new ArrayList<>();
        List<List<String>> list = new ArrayList<List<String>>();
        int delnumber = 0;// 第一页去除行数
        Sheet sheet = wb.getSheet(sheetName);
        this.totalRows = sheet.getPhysicalNumberOfRows() - delnumber; // 获取工作表中行数
        if (this.totalRows >= 1 && sheet.getRow(delnumber) != null) {
            this.totalCells = sheet.getRow(0)
                    .getPhysicalNumberOfCells(); // 得到当前行的所有单元格
            for (int j = 0; j < totalRows; j++) {
                List<String> rowLst = new ArrayList<String>();
                for (int f = 0; f < totalCells; f++) {
                    if (totalCells > 0) {
                        String value = getCell(sheet.getRow(j).getCell(f));
                        rowLst.add(value);
                    }
                }
                list.add(rowLst);
            }
        }
        return list;
    }
    /*
     * private String getRightStr(String sNum) { DecimalFormat decimalFormat =
     * new DecimalFormat("##.00"); String resultStr = decimalFormat.format(new
     * Double(sNum)); if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) { resultStr =
     * resultStr.substring(0, sNum.indexOf(".")); } return resultStr; }
     */

    public String getCell(Cell cell) {
        String cellValue = null;
        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
        cellValue = hSSFDataFormatter.formatCellValue(cell); // 使用EXCEL原来格式的方式取得值
        return cellValue;
    }

    /**
     * 去除 字符串收尾的 特殊的Unicode [ "\uFEFF" ]
     * csv 文件可能会带有该编码
     *
     * @param str
     * @return
     */
    private static String specialUnicode(String str) {
        if (str.startsWith("\uFEFF")) {
            str = str.replace("\uFEFF", "");
        } else if (str.endsWith("\uFEFF")) {
            str = str.replace("\uFEFF", "");
        }
        return str;
    }


}
