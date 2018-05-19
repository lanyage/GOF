package Register;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 适配器模式:结构型模式,用于使接口不兼容的类一起协作
 *
 * 客户端需要知道这类适配器的存在,而若是想适配其他的类,则需要再写适配器
 */
class Student {
    private String name;
    private int[] grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGrade() {
        return grade;
    }

    public void setGrade(int[] grade) {
        this.grade = grade;
    }
}

class InfoSystem {
    public int[] getGradeOf(Student student) {
        return student.getGrade();
    }
}

class InfoSystemAdapter {
    InfoSystem infoSystem = new InfoSystem();

    public String getGradeOf(Student student) {
        StringBuilder sb = new StringBuilder();
        int[] grade = student.getGrade();
        int len = grade.length;
        for (int i = 0; i < len; i++) {
            switch (i) {
                case 0:
                    sb.append("语文:" + grade[i]);
                    break;
                case 1:
                    sb.append("  数学:" + grade[i]);
                    break;
                case 2:
                    sb.append("  英语:" + grade[i]);
                    break;
                case 3:
                    sb.append("  生物:" + grade[i]);
                    break;
                case 4:
                    sb.append("  化学:" + grade[i]);
                    break;
                case 5:
                    sb.append("  物理:" + grade[i]);
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
}

/**
 * 获取的数据格式不是我们所希望的,所以我们希望能改变数据的格式
 * <p>
 * 这里考虑的是老师能够自己使用这个操作系统,如果不懂系统的话那我们这里需要提供一个懂系统的人物类型,如SystemManager
 */
class SystemManager {
    InfoSystemAdapter infoSystemAdapter = new InfoSystemAdapter();

    public String searchGradeOf(Student student) {
        return infoSystemAdapter.getGradeOf(student);
    }
}

class Teacher {
    public static void main(String[] args) {
        SystemManager systemManager = new SystemManager();

        Student student = new Student();
        student.setName("张三");
        student.setGrade(new int[]{80, 60, 59, 89, 90, 88});
        System.out.println("-------老师请求信息系统的管理员来查询(" + student.getName() + ")的成绩------");
        System.out.println(systemManager.searchGradeOf(student));
        student = new Student();
        student.setName("李四");
        student.setGrade(new int[]{80, 77, 68, 86, 92, 78});
        System.out.println("-------老师请求信息系统的管理员来查询(" + student.getName() + ")的成绩------");
        System.out.println(systemManager.searchGradeOf(student));
    }
}
