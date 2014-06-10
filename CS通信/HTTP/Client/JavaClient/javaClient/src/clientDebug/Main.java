package clientDebug;

import htmlHelper.person;

import javax.xml.ws.Service;

import BaseApiCommon.InvokeParam;
import UserServiceInterface.IUserService;
import UserServiceInterface.UserInfo;
import UserServiceInterface.javaUserInfo;

public class Main {

	public static String url = "http://localhost:2015/HLService.aspx?Type=java";

	public static void main(String[] args) {
		System.out.println("����ʼ��");
		try {
			// C# ����˵� �ඨ�����ƿռ�����java����һ��
			// C# ʵ������뺬���ֶζ�Ӧjava���� 
			javaUserInfo us = (javaUserInfo) InvokeMember(
					"UserServiceInterface.IUserService", "GetAllUser", null);
			System.out.println(us.get_id() + us.get_code());
		} catch (Exception e) {
		}
	}

	/**
	 * ���ݽӿ����� ���������� ���������ӷ������������
	 * 
	 * @param intface
	 *            ��.�ӿ���
	 * @param moduleName
	 *            ��������
	 * @param p
	 *            ����
	 * @return
	 * 
	 */
	public static <T> T InvokeMember(String intface, String moduleName,
			Object[] p) {
		Object obj = null;
		try {
			BaseApiCommon.javaInvokeParam parm = new BaseApiCommon.javaInvokeParam(
					intface, moduleName, p);
			byte[] buff = htmlHelper.XmlEasy.xmlOutputByte(parm);
			byte[] bytes = htmlHelper.GetPost.post(url, buff);
			obj = htmlHelper.XmlEasy.xmlInputObj(bytes);
		} catch (Exception e) {
		}
		return (T) obj;
	}
}
