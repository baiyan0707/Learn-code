package blog.baiyan.github.excel.easyexcel.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author bai
 * @Description
 * @Date 2020/8/7 9:18 AM
 */
@Data
public class UserHealthInfo {

    private String user;        // 用户ID
    private String familyHistory;        // 家族史
    private String femaleHistory;        // 女性家族史
    private String healthHistory;        // 健康史
    private String allergyHistory;        // 过敏史
    private String currentDisease;        // 目前疾病

    private Double height;        // 身高
    private Double weight;        // 体重
    private Double waistline;        // 腰围
    private String bloodPressure;        // 收缩压/舒张压
    private Double pulse;        // 脉搏
    private Double temperature;        // 体温
    private Double FBS;        // 空腹血糖
    private Double TG;        // 甘油三酯
    private Double UA;        // 尿酸
    private Double TC;        // 总胆固醇
    private Double LDL;        // 低密度脂蛋白
    private Double HDL;        // 高密度脂蛋白
    private String status;  // 0.在岗 1.调学 2.调动 3.退役 4.其他，可初始化

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHealthInfo that = (UserHealthInfo) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(familyHistory, that.familyHistory) &&
                Objects.equals(femaleHistory, that.femaleHistory) &&
                Objects.equals(healthHistory, that.healthHistory) &&
                Objects.equals(allergyHistory, that.allergyHistory) &&
                Objects.equals(currentDisease, that.currentDisease) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(waistline, that.waistline) &&
                Objects.equals(bloodPressure, that.bloodPressure) &&
                Objects.equals(pulse, that.pulse) &&
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(FBS, that.FBS) &&
                Objects.equals(TG, that.TG) &&
                Objects.equals(UA, that.UA) &&
                Objects.equals(TC, that.TC) &&
                Objects.equals(LDL, that.LDL) &&
                Objects.equals(HDL, that.HDL) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, familyHistory, femaleHistory, healthHistory, allergyHistory, currentDisease, height, weight, waistline, bloodPressure, pulse, temperature, FBS, TG, UA, TC, LDL, HDL, status);
    }
}
