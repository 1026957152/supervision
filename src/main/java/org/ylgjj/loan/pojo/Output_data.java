package org.ylgjj.loan.pojo;

import java.util.Arrays;
import java.util.List;

public class Output_data {


    Object result;
/*    private String ret;
    private String msg;*/
    private boolean success;

    public Object getData() {
        return result;
    }

    public void setData(Object data) {
        this.result = data;
    }


    public static Output_data 情况1_返回成功(List<Object> data) {
        Output_data returnResult = new Output_data();
        returnResult.setData(data);
      //  returnResult.setRet("0");
       // returnResult.setMsg("返回成功");

        return returnResult;
    }



    public static Output_data 情况2_查询为空() {
        Output_data returnResult = new Output_data();

     //   returnResult.setRet("1");
      //  returnResult.setMsg("查询为空");

        return returnResult;
    }

    public static Output_data 情况3_您没有权限访问(String message) {
        Output_data returnResult = new Output_data();

      //  returnResult.setRet("2");
       // returnResult.setMsg("您没有权限访问："+message);

        return returnResult;
    }

    public static Output_data 情况4_入参数格式错误(String msg) {
        Output_data returnResult = new Output_data();

        returnResult.setSuccess(false);
        returnResult.setData(Arrays.asList("入参数格式错误:"+msg));

        return returnResult;
    }

    public static Output_data 情况5_操作失败() {
        Output_data returnResult = new Output_data();

    //    returnResult.setRet("99");
     //   returnResult.setMsg("操作失败");

        return returnResult;
    }
    public static Output_data 情况5_操作失败(String e) {
        Output_data returnResult = new Output_data();

       // returnResult.setRet("99");
     //   returnResult.setMsg("操作失败:"+e);

        return returnResult;
    }
/*

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getRet() {
        return ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
*/

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }
}
