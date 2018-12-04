package com.platform.base.enums;


/**
 *
 * @author gaopj
 */
public class ConstantsCore {

	/**
	 * @author gaopj
	 * 区分来源
	 */
	public static enum OSourceEnum{
		IOS,//ios操作系统
		ANDROID,//andrioid操作系统
		;
	}

	/**
	 * @author gaopj
	 * 接口调用返回码和消息
	 */
	public static enum SystemInfoEnum{

		//统一成功返回码：
		SUCCESS("200","接口调用成功","Successful interface call"),
		ILLEGAL_REQUEST("300","违法请求","Illegal request,"),

		REGISTER_FAIL("10002","注册接口报错，注册失败","Registered interface error, failure"),
		USER_NOT_EXISTS("10005","用户不存在","The user does not exist"),
		MANY_USER("10006","不是唯一的用户","not the only user"),
		LOGIN_FAIL("10007","登陆接口报错，登陆失败","Landing interface error, failure"),
		NOT_FOUND_USERINFO("10008","找不到该用户的详细信息","Can't find the details of the user"),
		USER_DISABLED("10009","用户为不可用状态","The user is unavailable"),
		USER_EXISTS("10010","用户已存在","User already exists"),
		ERROR_REQUEST("10011","错误的请求类型","The wrong type of request"),
		CREATE_ROOM_FAIL("10012","创建房间失败","Create room faile"),
		CREATE_ROOM_EXCEPTION("10013","创建房间异常","Create room exception"),
		USERID_CAN_NOT_BE_NULL("10014","用户id不能为空","UserId can not be null"),
		NAME_OR_PASSWORD_ERROR("10015","用户名或密码错误","The user name or password error"),
		EMPTY_CART("10016","购物车不能为空","Shopping cart can't be null"),
		PRE_CREATE_ROOM_FAIL("10017","预创建房间失败","Failed to create a room in advance"),
		PRE_CREATE_ROOM_EXCEPTION("10018","预创建房间接口异常","Create room interface Exception"),
		PRE_CREATE_ROOM_NOT_FOUND("10019","正式创建房间失败，找不到预创建的房间","pre create room not found"),
		INVOKE_CART_EXCEPTION("10020","购物车信息获取异常","Catr detail infomation Exception"),
		SETTLEEMENT_EXCEPTION("10021","结算接口异常","Settlement interface call Exception"),
		GOODS_ID_CAN_NOT_NULL("10022","结算的商品不能为空","Settlement goods can't be null"),
		CHECK_USER_EXCEPITON("10023","注册校验接口异常","Register interface call Excepiton"),
		INVALID_PARAMETER("10024","无效的请求参数","Invalid request parameters"),
		CART_GOODS_PRICE_CHANGED("10025","购物车商品价格变动","Goods price has changed"),
		CART_GOODS_LOW_STOCKS("10026","购物车商品库存不足","Goods is low stocks"),
		CART_GOODS_LINE_OFF("10027","购物车商品已下架","Goos is line off"),
		MAKER_ORDER_ERROR("10028","订单生成异常","Make order error"),
		USER_NAME_ILLEGAL("10029","用户名称参数错误","User name must be email or phone"),
		NO_ORDER_INFO("10030","该用户没有订单信息","The user has not an order"),
		NO_ORDER_DETAIL_INFO("10031","该用户没有订单详情信息","Order info is not found"),
		QUERY_ORDER_LIST_EXCEPTION("10032","查询订单列表异常","Query order list,Exception"),
		QUERY_ORDER_TEYP_ERROR("10033","查询订单详情参数错误","Query order detail parameter error"),
		QUERY_ORDER_DETAIL_EXCEPTION("10034","查询订单详情异常","Query order detail Exception"),
		QUERY_PRODUCT_EXCEPTION("10035","查询房间对应的产品详情异常","Query room product"),
		GOODS_NOT_FOUND("10036","通过sku找不到对应的商品","No such goods of sku"),
		ADD_CART_EXCEPTION("10037","通过sku添加对应商品到购物车异常","Special add to cart Exception"),
		QUERY_MY_ROOM_EXCEPTION("10038","查询我的直播列表异常","Query my room list Exception"),
		UPDATE_ROOM_EXCEPTION("10039","更新房间信息失败","Update room info Exception"),
		CANCEL_ORDER_FAIL("10040","取消订单失败","Cancel order fail"),
		CANCEL_ORDER_EXCEPTION("10041","取消订单接口异常","Cancel order exception"),
		ORDER_NOT_FOUND("10042","微信预支付找不到相应订单","Order not found when pay"),
		DELETE_GROUP_MEMBER_EXCEPTION("10043","从腾讯群组静默删除异常","silence delete group member Exception"),
		UPDATE_ORDER_EXCEPITON("10044","订单更新异常","update order Exception"),
		INVOKE_WXPAY_ERROR("10045","调用微信统一下单接口出错","Invoke wxpay error"),
		GET_WX_PREPAYID_EXCEPTION("10046","获取预支付id异常","get wx prepayid Exception"),
		LOGISTICS_NOT_FOUND("10047","查询不到物流公司列表","Logistics list is not found"),
		LOGISTICS_LIST_EXCEPTION("10048","查询物流公司异常","Query logistics list Exception"),
		QUERY_INCOME_EXCEPTION("10049","查询收入异常","Query income list Exception"),
		SET_OR_CANCEL_REMIND_EXCEPTION("10050","设置或者取消提醒异常","set or cancel remind Exception"),
		QUERY_ROOM_ORDER_EXCEPTION("10051","查询当前直播房间生成的订单信息异常","query room order Exception"),
		//10100----
		ROOM_NOT_EXISTS("10102","信息不存在","The room does not exist"),
		ROOM_FAIL("10103","查询接口获取失败","Hot interface error,falure"),
		PAGER_NOT_EXISTS("10104","分页参数不存在","Pager paraments not exist"),
		DATE_NOT_EXISTS("10105","日期时间不存在","Date not exist"),
		INSERT_FAIL("10106","信息插入失败","insert interface failure"),
		PARAMETER_NOT_EXISTS("10107","参数不存在","paraments not exist"),
		INFORMATION_NOT_EXISTS("10108","信息不存在","The information does not exist"),
		QUERY_EXCEPTION("10109","查询接口异常","query exception"),
		UPDATE_EXCEPTION("10110","修改接口异常","update exception"),
		DELETE_EXCEPTION("10111","删除接口异常","delete exception"),
		QUERY_USE_ADDRESS_MULTITERM ("10112","当前用户最新或者默认地址存在多条数据","query use address multiterm"),
		QUERY_USE_ADDRESS_NOT_EXISTS ("10113","当前用户地址不存在","query use address not exists"),
		QUERY_USE_ADDRESS_ALREADY_EXISTS ("10114","查询收货人最新使用地址已存在","query use address already exists"),
		QUERY_MY_CONCERN_ALREADY_EXISTS ("10115","当前用户所关注的人已存在","query my concern already exists"),
		QUERY_BANKCARD_ALREADY_EXISTS ("10116","该用户已绑定过银行卡","query bankcard already exists"),
		QUERY_BANKCARD_NOT_EXISTS ("10117","该用户没有和该银行卡绑定","query bankcard not exists"),
		CASH_BALANCE_DEFICIENCY ("10118","提现余额不足","cash balance deficiency"),
		UPlOAD_HEADICON_EXCEPTION ("10119","上传头像异常","upload headicon exception"),
		QUERY_USERACCOUNT_NOT_EXISTS ("10120","该用户的账户信息不存在","query useraccount not exists"),
		QUERY_BALANCE_ZERO ("10121","该用户的账户为0,不能体现","query balance zero"),
		QUERY_PRODUCT_NOT_EXISTS("10121","产品信息不存在","query product not exist"),
		PASSWORD_ERROR("10122","原密码输入错误","password error"),
		INSERT_EXIST_DUPLICATE_RECORDS("10123","插入的记录系统已存在","insert exist duplicate records"),
		USERACCOUNT_NOT_EXISTS("10124","该用户的账户信息不存在","useraccount not exists"),
		PAY_PASSWORD_ERROR("10125","原支付密码输入错误","paypassword error"),
		PAY_PASSWORD_NOT_SET("10126","原支付密码没有设置","paypassword not set"),
		PAY_PASSWORD_ALREADY_SET("10127","原支付密码已设置","paypassword already set"),
		PREROOM_ALREADY_EXISTS("10128","预约房间已存在","preroom already exists"),
		;
		public  String code;
		public  String msg;
		public String en_msg;
		private SystemInfoEnum(String code,String msg,String en_msg){
			this.code = code;
			this.msg = msg;
			this.en_msg = en_msg;
		}

		public String getMsg(String language){

			if("0".equals(language)){
				return this.msg;
			}else{
				return this.en_msg;
			}
		}

	}
	/**卖家买家**/
	public static enum UserTypeEnum{
		BUYER(0,"买家"),//0
		SELLER(1,"卖家"),//1
		;
		public int code;
		public String name;
		private UserTypeEnum(int code,String name){
			this.code = code;
			this.name = name;
		}
	}
	/**用户状态:前端用户和后台管理员都用此枚举**/
	public static enum UserStatusEnum{
		DISABLE(0,"禁用用户"),
		NORMAL(1,"正常用户"),
		;
		public int code;
		public String message;

		private UserStatusEnum(int code,String message){
			this.code = code;
			this.message = message;
		}

	}
	/**upload**/
	public static enum UploadTypeEnum{
		HEAD_PIC("headPic","头像上传"),
		PRODUCT_PIC("productPic","产品图片"),
		ROOM_PIC("roomPic","房间封面"),
		OTHER_PIC("otherPic","其他图片"),
		;
		public String name;
		public String message;

		private UploadTypeEnum(String name,String message){
			this.name = name;
			this.message = message;
		}
	}

	/***测试方法****/
	public static void main(String[] args) {

	}

	/**表字段编号生成前缀***/
	public static enum IDPrefix{
		TBROOM("room101"),
		TBPRODUCT("pro101"),
		TBPRODUCTPICTURE("pic101"),
		TBPRODUCTGOODS("goods101"),
		TBORDER("ord201"),
		TBORDER_DETAIL("ordd301"),
		TBADDRESS("addr201"),
		TBBANKCARD("card601"),
		TBWITHDRAW("draw701"),
		TBUSERACCOUNT("user801"),
		TBWAYBILL("wayb901"),
		TBFEEDBACK("feedb909"),
		TBPUSH("ph102"),
		TBUSERACCOUNTINCOME("ic103"),
		;
		public String prefix;
		private IDPrefix(String prefix){
			this.prefix = prefix;
		}

	}
	/**购物车动作***/
	public static enum CartActionEnum{
		QUERY("0"),//对购物车查询
		ADD("1"),//新增
		REDUCE("2"),//减少
		DEL("3"),//删除
		UPDATE("4"),//更新
		EMPTY("5"),//清空
		;
		public String type;
		private CartActionEnum(String type){
			this.type = type;
		}

		public static CartActionEnum getEnum(String type) {
			if(null == values() || values().length <=0){
				System.out.println("-----------");
			}
			for (CartActionEnum obj : values()) {
				if (obj.type.equals(type)){
					return obj;
				}
			}
			return null;
		}
	}

	/***订单状态枚举*
	 '订单状态：1、已提交（未付款）；2、已取消；3、已付款；
	 4、已关闭；5、已发货；6、已退单；
	 7、已签收；8、已完成；9、退单中',
	 -1 已删除(不在查询列表中存在)
	 ***/
	public static enum OrderStatusEnum{
		DELETED(-1,"已删除"),
		WAITPAY(1,"已提交"),
		CANCEL(2,"已取消"),
		PAYED(3,"已付款"),
		CLOSED(4,"已关闭"),
		DELIVERED(5,"已发货"),
		CHARGEBACK(6,"已退单"),
		SIGNED(7,"已签收"),
		DONE(8,"已完成"),
		CHARGEBACKING(9,"退单中"),
		;
		public int code;
		public String info;
		private OrderStatusEnum(int code,String info){
			this.code = code;
			this.info = info;
		}
		public static OrderStatusEnum getEnum(int code){
			for (OrderStatusEnum obj : values()) {
				if(obj.code == code){
					return obj;
				}
			}
			return null;
		}
	}

	/****订单列表查询状态枚举*****/
	public static enum QryORDTypeEnum{
		ALL("0"),//全部订单
		WAITPAY("1"),//待付款订单
		WAITSIGN("2"),//待签收订单
		WAITSEND("3"),//待发货订单
		WATIPJ("4"),//待评价
		;
		public String code;
		private QryORDTypeEnum(String code){
			this.code = code;
		}
		public static QryORDTypeEnum getEnum(String code) {
			for (QryORDTypeEnum obj : values()) {
				if (obj.code.equals(code)){
					return obj;
				}
			}
			return null;
		}
	}

	/********腾讯发送消息的类型枚举************/
	public static enum TXMessageTypeEnum{

		TIMTextElem("TIMTextElem","文本消息"),
		TIMLocationElem("TIMLocationElem","地理位置消息"),
		TIMFaceElem("TIMFaceElem","表情消息"),
		//自定义消息，当接收方为IOS系统且应用处在后台时，此消息类型可携带除文本以外的字段到APNS。
		//注意，一条组合消息中只能包含一个TIMCustomElem自定义消息元素。
		TIMCustomElem("TIMCustomElem","自定义消息"),
		TIMSoundElem("TIMSoundElem","语音消息"),//服务端集成Rest API不支持发送该类消息
		TIMImageElem("TIMImageElem","图像消息"),//服务端集成Rest API不支持发送该类消息
		TIMFileElem("TIMFileElem","文件消息"),//服务端集成Rest API不支持发送该类消息
		;
		public String code;
		public String desc;
		private TXMessageTypeEnum(String code,String desc){
			this.code = code;
			this.desc = desc;
		}
	}
	/***支付类型枚举****/
	public static enum PayTypeEnum{
		WXPAY("0","微信支付"),
		ALIPAY("1","支付宝"),
		;
		public String code;
		public String desc;
		private PayTypeEnum(String code,String desc){
			this.code = code;
			this.desc = desc;
		}
	}
	/***订单更新类型枚举***/
	public static enum OrderUpdateEnum{
		DELIVER("0","卖家发货，并填写运单号"),
		SIGNED("1","买家签收"),
		DONE("2","订单完成"),
		;
		public String code;
		public String desc;
		private OrderUpdateEnum(String code,String desc){
			this.code = code;
			this.desc = desc;
		}
		//根据code获取枚举类
		public static OrderUpdateEnum getOrderUpdateEnum(String code){
			for (OrderUpdateEnum obj : values()) {
				if (obj.code.equals(code)){
					return obj;
				}
			}
			return null;
		}
	}
	/***后台发送广播类型枚举**/
	public static enum SendMessageTypeEnum{
		SALES_MESSAGE("sales_message","广播交易量"),
		BULLET_MESSAGE("bullet_message","广播弹幕"),
		PEOPLESUM_MESSAGE("peoplesum_message","广播房间当前人数"),
		REMIND_PEOPLE("remind_people","发广播通知设置过提醒的人"),//针对即将开播的预告
		REMIND_SELLER("remind_seller","发送广播通知发起过预告的卖家"),//针对直播即将开始，通知主播
		HAS_PAY_ORDER("has_pay_order","发送付完款的订单信息"),//针对卖家发送当前房间已经付款的订单
		UMENG_PUSH("umeng_push","友盟推送");//针对设置过提醒预告的用户，进行友盟推送
		;
		public String code;
		public String desc;
		private SendMessageTypeEnum(String code,String desc){
			this.code = code;
			this.desc = desc;
		}
		public static SendMessageTypeEnum getEnum(String sendType) {
			for (SendMessageTypeEnum obj : values()) {
				if(sendType.equals(obj.code)){
					return obj;
				}
			}
			return null;
		}
	}
	/****字符集****/
	public static final String UTF8_CHAR_SET="utf-8";
	/****腾讯云通信模拟发消息API******/
	public final static String GROUP_SEND_MESSAGE_API = "https://console.tim.qq.com/v4/group_open_http_svc/send_group_msg?";
	/****腾讯云通信进入直播前静默删除此人api******/
	public final static String DELETE_GROUP_MEMBER = "https://console.tim.qq.com/v4/group_open_http_svc/delete_group_member?";
	/****腾讯云通信进入直播前查询此人在群组中的信息api******/
	public final static String GROUP_MEMBER_INFO_API= "https://console.tim.qq.com/v4/group_open_http_svc/get_role_in_group?";
	/****腾讯云通信标配用户资料***/
	public final static String portrait_set = "https://console.tim.qq.com/v4/profile/portrait_set?";
	/***将用户资料导入腾讯云***/
	public final static String account_import = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?";
	/****友盟推送api*****/
	public final static String UMENG_PUSH_API = "http://api.yimigongchang.com/Demo.php?";

	/***商品库存统一,每个商品每单只能买20个***/
	public static final int STORAGE_NUM = 20;
	/*****thrift***********/
	public static final int THRIFT_PORT=8111;
	public static final String SERVER_IP = "127.0.0.1";
	public static final int TIMEOUT = 30000;
	/*****thrift***********/
	/**指定发送销量广播的人*/
	public final static String SALES_ADMIN="salesAdmin";
	/*** 指定发送弹幕广播的人*/
	public final static String BULLET_ADMIN="bulletAdmin";
	/*** 指定发送当前房间观看数广播的人*/
	public final static String PEOPLESUM_ADMIN="peoplesumAdmin";
	/****指定发送当前房间已付款订单的数量的人数****/
	public final static String HASPAYORDER_ADMIN="haspayorderAdmin";
	/******未付款订单在30分钟之后关闭******/
	public final static int TASK_TIME = 30;
}
