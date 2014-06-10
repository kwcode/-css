package htmlHelper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPost {

	public static void main(String[] args) {
		// �˵�ַΪC# ����˹̶���ַ
		String url = "http://localhost:2015/HLService.aspx?type=0";
		try {

			byte[] PostData = htmlHelper.ConvertType
					.ConvertStringToByte("paraaa123�ҼӴ���");
			byte[] buff = post(url, PostData);
			String str = htmlHelper.ConvertType.ConvertByteToString(buff);
			System.out.println(str);

			buff = get("http://www.baidu.com");
			str = htmlHelper.ConvertType.ConvertByteToString(buff);
			System.out.println(str);
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

	/**
	 * java.net ��Ӧ��[java�ı�׼�ӿ�]
	 */
	public static byte[] get(String httpurl) throws IOException {
		URL url = new URL(httpurl);
		java.net.HttpURLConnection con = (HttpURLConnection) url
				.openConnection();

		con.setConnectTimeout(100000);// ���ӳ�ʱ ��λ����
		con.setReadTimeout(20000);// ��ȡ��ʱ ��λ����
		InputStream inStream = con.getInputStream();
		return htmlHelper.ConvertType.ConvertStreamToByte(inStream);
	}

	public static byte[] post(String httpurl, byte[] buff) throws IOException {
		URL url = new URL(httpurl);
		java.net.HttpURLConnection con = (HttpURLConnection) url
				.openConnection();
		con.setRequestMethod("POST");// Ĭ��GETk
		con.setConnectTimeout(100000);// ���ӳ�ʱ ��λ����
		con.setReadTimeout(20000);// ��ȡ��ʱ ��λ����
		con.setDoOutput(true);// �Ƿ��������
		con.getOutputStream().write(buff);// �������
		InputStream inStream = con.getInputStream();
		return htmlHelper.ConvertType.ConvertStreamToByte(inStream);
	}
}
