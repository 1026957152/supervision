package org.ylgjj.loan.domain;

public class ReturnResult {

    String ret;
    String msg;


    Data[] data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public static ReturnResult 情况1_返回成功(Data[] data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setData(data);
        returnResult.setRet("0");
        returnResult.setMsg("返回成功");

        return returnResult;
    }



    public static ReturnResult 情况2_查询为空() {
        ReturnResult returnResult = new ReturnResult();

        returnResult.setRet("1");
        returnResult.setMsg("查询为空");

        return returnResult;
    }

    public static ReturnResult 情况3_您没有权限访问(String message) {
        ReturnResult returnResult = new ReturnResult();

        returnResult.setRet("2");
        returnResult.setMsg("您没有权限访问："+message);

        return returnResult;
    }

    public static ReturnResult 情况4_入参数格式错误(String msg) {
        ReturnResult returnResult = new ReturnResult();

        returnResult.setRet("3");
        returnResult.setMsg("入参数格式错误:"+msg);

        return returnResult;
    }

    public static ReturnResult 情况5_操作失败() {
        ReturnResult returnResult = new ReturnResult();

        returnResult.setRet("99");
        returnResult.setMsg("操作失败");

        return returnResult;
    }
    public static ReturnResult 情况5_操作失败(String e) {
        ReturnResult returnResult = new ReturnResult();

        returnResult.setRet("99");
        returnResult.setMsg("操作失败:"+e);

        return returnResult;
    }


}
