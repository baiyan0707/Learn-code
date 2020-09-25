package blog.baiyan.github.excel.poiexcel.utils;


import blog.baiyan.github.excel.poiexcel.dto.UserHealthInfoDTO;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * @author bai
 * @Description
 * @Date 2020/8/7 2:09 PM
 */

public class ExcelUtil2 {

    public <T> List<T> parseFromExcel(String path, Class<T> aimClass) {
        return this.parseFromExcel(path, 0, aimClass);
    }

    @SuppressWarnings("deprecation")
    public <T> List<T> parseFromExcel(String path, int firstIndex, Class<T> aimClass) {
        List<T> result = new ArrayList<T>();
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            //对excel文档的第一页,即sheet1进行操作
            Sheet sheet = workbook.getSheetAt(0);
            int lastRaw = sheet.getLastRowNum();
            for (int i = firstIndex; i < lastRaw; i++) {
                //第i行
                Row row = sheet.getRow(i);
                T parseObject = aimClass.newInstance();
                Field[] fields = aimClass.getDeclaredFields();
                for (int j = 0; j < fields.length; j++) {
                    Field field = fields[j];
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    //第j列
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    //很重要的一行代码,如果不加,像12345这样的数字是不会给你转成String的,只会给你转成double,而且会导致cell.getStringCellValue()报错
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String cellContent = cell.getStringCellValue();
                    cellContent = "".equals(cellContent) ? "0" : cellContent;
                    if (type.equals(String.class)) {
                        field.set(parseObject, cellContent);
                    } else if (type.equals(char.class) || type.equals(Character.class)) {
                        field.set(parseObject, cellContent.charAt(0));
                    } else if (type.equals(int.class) || type.equals(Integer.class)) {
                        field.set(parseObject, Integer.parseInt(cellContent));
                    } else if (type.equals(long.class) || type.equals(Long.class)) {
                        field.set(parseObject, Long.parseLong(cellContent));
                    } else if (type.equals(float.class) || type.equals(Float.class)) {
                        field.set(parseObject, Float.parseFloat(cellContent));
                    } else if (type.equals(double.class) || type.equals(Double.class)) {
                        field.set(parseObject, Double.parseDouble(cellContent));
                    } else if (type.equals(short.class) || type.equals(Short.class)) {
                        field.set(parseObject, Short.parseShort(cellContent));
                    } else if (type.equals(byte.class) || type.equals(Byte.class)) {
                        field.set(parseObject, Byte.parseByte(cellContent));
                    } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
                        field.set(parseObject, Boolean.parseBoolean(cellContent));
                    }
                }
                result.add(parseObject);
            }
            fis.close();
            return result;
        } catch (

                Exception e) {
            e.printStackTrace();
            System.err.println("An error occured when parsing object from Excel. at " + this.getClass());
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        //参数里的5表示有效行数从第5行开始
        ExcelUtil2 excelUtil2 = new ExcelUtil2();
        List<UserHealthInfoDTO> studentInfos = excelUtil2.parseFromExcel("/Users/bai/Desktop/2020.8.5.xls", 2,
                UserHealthInfoDTO.class);
        for (int i = 0; i < studentInfos.size(); i++) {
            System.err.println(studentInfos.get(i).toString());
        }
        System.out.println("size(): " +studentInfos.size());
    }
}