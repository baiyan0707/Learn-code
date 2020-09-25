package blog.baiyan.github.excel.poiexcel.dto;

/**
 * @author bai
 * @Description
 * @Date 2020/8/7 11:20 AM
 */
public class UserHealthInfoDTO {

    private String titel;

    private String year;

    private String orderNumber;

    private String gender;

    private String age;

    private String project;

    private String examProject;

    private String result;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserHealthInfoDTO{" +
                "titel='" + titel + '\'' +
                ", year='" + year + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", project='" + project + '\'' +
                ", examProject='" + examProject + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getExamProject() {
        return examProject;
    }

    public void setExamProject(String examProject) {
        this.examProject = examProject;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
