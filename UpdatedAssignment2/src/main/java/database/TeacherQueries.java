package database;

public class TeacherQueries {

    public String getExamTableData(String numestudent, String data1, String data2) {
        return "select * from exam where numestudent ='"+numestudent+"' and dataexamen between '"+data1+"' and '"+data2+"';";
    }

}
