package blog.baiyan.github.excel.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName ImportExcelExampleEntity
 * @Description TODO
 * @Author Forlevin
 * @Date 2020/7/29 15:23
 * @Version 1.0
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ImportExcelExampleEntity extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "预约号码",index = 2)
    private String orderNumber;

    @ExcelProperty(value = "性别",index = 3)
    private String gender;

    @ExcelProperty(value = "年龄",index = 4)
    private String age;

    @ExcelProperty(value = "项目组合",index = 5)
    private String project;

    @ExcelProperty(value = "体检项目", index = 6)
    private String examProject;

    @ExcelProperty(value = "体检结果", index = 7)
    private String result;


}
