package org.ylgjj.loan.domain;

import java.math.BigDecimal;

public class Data_CEB {

    String stdpid;//	流水号	CHAR	20	Y
    String stdmerrslt;//	信息校验结果	CHAR	1	Y
    String stdjcfsdd;//	公积金中心行政机构代码	CHAR	20	Y
    String stdsjfsjg;//	中心机构代码	CHAR	6	Y
    String std400cunm;//	申请人基本信息 姓名	CHAR	60	Y
    String std400dfnm;//	申请人基本信息 姓名简拼	CHAR	60
    String std400sexx;//	申请人基本信息 性别	CHAR	1	Y


    String std400rgid;//	申请人基本信息 个人登记号	CHAR	32
    String std400grid;//	申请人公积金号	CHAR	20	Y
    String idtp;// 	申请人基本信息 证件类型	CHAR	1	Y
    String std400idno;//	申请人基本信息 证件号码	CHAR	18	Y
    String std400brth;//	申请人基本信息 出生年月	CHAR	10	Y
    String std400wktm;//	申请人基本信息 参加工作时间	CHAR	10	Y
    String std400sqam;//	申请人基本信息 税前工资总额	NUMBER	12	Y
    String std400gddh;//	申请人基本信息 住宅电话	NUMBER	12
    String std400mobl;//	申请人基本信息 手机号	NUMBER	12
    String std400addr;//	申请人基本信息 联系地址(家庭）	CHAR	500
    String        stdcmpnm;//	申请人现缴存单位信息 单位名称	CHAR	500	Y
    String        stdcmprgno;//	申请人现缴存单位信息单位登记号	CHAR	32
    String       stdcmpkhid;//	申请人现缴存单位信息 开户管理部编号	CHAR	20
    String        stdcmprgtm;//	申请人现缴存单位信息 初次登记时间	CHAR	10	Y
    String        stdcmpzzno;//	申请人现缴存单位信息 组织机构代码	CHAR	20	Y
    String        stdcmpzyyno;//	申请人现缴存单位信息 营业执照号码(工商注册号)	CHAR	20	Y
    String stdcmpprpt;//	申请人现缴存单位信息 性质代码	CHAR	2	Y
    String stdcmpaddr;//	申请人现缴存单位信息 单位地址	CHAR	500	Y
    String stdcmpjczt;//	申请人现缴存单位信息 单位缴存状态	CHAR	3	Y
    String stdcmpjcly;//	申请人现缴存单位信息 单位缴存资金来源	CHAR	1
    String stdcmpdbnm;//	申请人现缴存单位信息 法定代表人或负责人	CHAR	20
    String stdcmptel;//	申请人现缴存单位信息 单位联系方式	CHAR	20
    String stdcmpkhbk;//	申请人现缴存单位信息 单位开户银行及行号（缴存银行）	CHAR	3	Y
    String stdcmpacno;//	申请人现缴存单位信息 单位账号	CHAR	20
    String stdcmpfxrq;//	申请人现缴存单位信息 发薪日期（缴交日）	CHAR	8
    String stdcmphjfg;//	申请人现缴存单位信息 是否申请公积金缓缴	CHAR	1
    String stdcmphjdt;//	申请人现缴存单位信息 申请缓缴时间	CHAR	10
    String stdcmphjrn;//	申请人现缴存单位信息 申请缓缴的原因	CHAR	128



















    String stdgjjacno;//	个人公积金账户信息 公积金账号	CHAR	20	Y
    String stdgjjrgdt;//	个人公积金账户信息 开户日期	CHAR	10	Y
    String stdgjjstdt;//	个人公积金账户信息 初缴年月日	CHAR	10	Y
    String stdgjjendt;//	个人公积金账户信息 缴至年月日	CHAR	10	Y
    String stdgjjennm;//	个人公积金账户信息 当月缴存单位名称	CHAR	1800	Y
    String stdglljcst;//	个人公积金账户信息 当月缴存状态	CHAR	50	Y
    String stdgjjltdt;//	个人公积金账户信息 最近一次缴交日期	CHAR	10	Y
    String stdgjjcdqnd;//	个人公积金账户信息 当前公积金年度	CHAR	4	Y
    String stdgjjjccs;//	个人公积金账户信息 累计缴存次数	NUMBER	8	Y
    String stdgjjacbl;//	个人公积金账户信息 当前余额	NUMBER	12	Y
    String stdgjjdwam;//	个人公积金账户信息 近12个自然月单位缴存额	NUMBER	12->170	Y
    String stdgjjdwsc;//	个人公积金账户信息 近12个自然月单位缴存比例	NUMBER	12->170	Y
    String stdgjjgram;//	个人公积金账户信息 近12个自然月个人缴存额	NUMBER	12->170	Y
    String stdgjjgrsc;//	个人公积金账户信息 近12个自然月个人缴存比例	NUMBER	12->170	Y


































    String stdgjjwdid;//	个人公积金提取信息 公积金账号	CHAR	20	Y
    String stdgjjwdrn;//	个人公积金提取信息 提取原因	CHAR	100->1500
    String stdgjjwddt;//	个人公积金提取信息 提取时间	CHAR	10->140	Y
    String stdgjjwdtp;//	个人公积金提取信息 提取方式	CHAR	2->40	Y
    String stdgjjhdze;//	个人公积金提取信息 核定提取总额	NUMBER	12	Y
    String stdgjjwdam;//	个人公积金提取信息 提取金额	NUMBER	12->170	Y
    String stdgjjouam;//	个人公积金提取信息 累计提取金额	NUMBER	12	Y
    String stdgjjtwdnm;//	个人公积金提取信息 共同提取人姓名	CHAR	60
    String stdgjjtwdno;//	个人公积金提取信息 共同提取人身份证号	CHAR	20
    String stdgjjtwdbd;//	个人公积金提取信息 共同提取人是否建立公积金	CHAR	2












































    String stdgjjdkid;//	个人公积金贷款信息 公积金账号	CHAR	20	Y
    String stdgjjdkbh;//	个人公积金贷款信息 公积金贷款编号	CHAR	20	Y
    String stdgjjdkam;//	个人公积金贷款信息 公积金贷款金额	NUMBER	12	Y
    String stdgjjdkpd;//	个人公积金贷款信息 公积金贷款期限	CHAR	8	Y
    String stdgjjppam;//	个人公积金贷款信息 公积金贷款月还款额	NUMBER	12	Y
    String stdgjjdkdt;//	个人公积金贷款信息 公积金贷款起始日期	CHAR	10	Y
    String stdgjjmudt;//	个人公积金贷款信息 公积金贷款到期日期	CHAR	10	Y
    String stdgjjjqdt;//	个人公积金贷款信息 公积金贷款结清日期	CHAR	10	Y
    String stdgjjtdknm;//	个人公积金贷款信息 共同贷款人姓名	CHAR	60
    String stdgjjtdkno;//	个人公积金贷款信息 共同贷款人身份证号	CHAR	20
    String stdgjjtdkbd;//	个人公积金贷款信息 共同贷款人是否建立公积金	CHAR	2
    String stdgjjdkaddr;//	个人公积金贷款信息 联系地址(家庭）	CHAR	256
    String       stdgjjdkzt;//	个人公积金贷款信息 贷款状态	CHAR	2	Y
    String       stdgjjdqzt;//	个人公积金贷款信息 当期还款状态	CHAR	2	Y
    String        stdgjjyqcs;//	个人公积金贷款信息 公积金贷款历史发生逾期次数	CHAR	4	Y
    String        stdgjjmyqcs;//	个人公积金贷款信息 最大连续的逾期期数（近24个月）	CHAR	4	Y
    String       stdhougfad;//	个人购/租房信息 个人购房地址	CHAR	256
    String        stdhouzfad;//	个人购/租房信息 个人租房地址	CHAR	256
    String       stdhougfam;//	个人购/租房信息 房屋购买记税价格	NUMBER	12
    String       stdhouzfam;//	个人购/租房信息 房屋租金	NUMBER	12






















}