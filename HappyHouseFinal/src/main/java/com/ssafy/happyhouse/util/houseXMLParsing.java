//package com.ssafy.happyhouse.util;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.sql.SQLException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//
//public class houseXMLParsing {
//
//	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, SQLException {
//		StringBuilder urlBuilder = new StringBuilder(
//				"http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcSHTrade"); /*URL*/
//		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
//				+ "A%2BGDNz5Hajm8xD4U2vkMRlyY70Xrsu6qpC1A3nv5edK9vZ0%2F2Zn3n5eVyDbr%2BHNjqhidfEfxMcjYESr35sGGvQ%3D%3D"); /*Service Key*/
//		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
//				+ URLEncoder.encode(
//						"A+GDNz5Hajm8xD4U2vkMRlyY70Xrsu6qpC1A3nv5edK9vZ0/2Zn3n5eVyDbr+HNjqhidfEfxMcjYESr35sGGvQ==",
//						"UTF-8")); /*공공데이터포털에서 받은 인증키*/
//		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//		urlBuilder.append(
//				"&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
//		urlBuilder.append(
//				"&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode("11110", "UTF-8")); /*지역코드*/
//		urlBuilder.append(
//				"&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "=" + URLEncoder.encode("201512", "UTF-8")); /*계약월*/
//		URL url = new URL(urlBuilder.toString());
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setRequestProperty("Content-type", "application/json");
//		System.out.println("Response code: " + conn.getResponseCode());
//		InputStream rd = conn.getInputStream();
//		String line;
//
//		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//
//		// 2. 빌더 팩토리로부터 빌더 생성
//		DocumentBuilder builder = builderFactory.newDocumentBuilder();
//
//		// 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
//		Document document = builder.parse(rd);
//
//		Element root = document.getDocumentElement();
//
//		NodeList nlist = document.getElementsByTagName("item");
//		System.out.println(nlist.getLength());
//		for (int i = 0; i < nlist.getLength(); i++) {
//			Node node = nlist.item(i);
//			if (node.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) node;
//				//				거래금액
//				NodeList dealAmount = null;
//				//				건축년도
//				NodeList buildYear = null;
//				//				년
//				NodeList year = null;
//				//				대지면적
//				NodeList area = null;
//				//				법정동
//				NodeList dong = null;
//				//				연면적
//				NodeList floorArea = null;
//				//				월
//				NodeList month = null;
//				//				일
//				NodeList day = null;
//				//				주택유형
//				NodeList houseType = null;
//				//				지역코드
//				NodeList code = null;
//				//				해제사유 발생일
//				NodeList cancelDay = null;
//				//				해제사유
//				NodeList cancelReason = null;
//
//				try {
//					dealAmount = eElement.getElementsByTagName("거래금액").item(0).getChildNodes();
//					buildYear = eElement.getElementsByTagName("건축년도").item(0).getChildNodes();
//					year = eElement.getElementsByTagName("년").item(0).getChildNodes();
//					area = eElement.getElementsByTagName("대지면적").item(0).getChildNodes();
//					dong = eElement.getElementsByTagName("법정동").item(0).getChildNodes();
//					floorArea = eElement.getElementsByTagName("연면적").item(0).getChildNodes();
//					month = eElement.getElementsByTagName("월").item(0).getChildNodes();
//					day = eElement.getElementsByTagName("일").item(0).getChildNodes();
//					houseType = eElement.getElementsByTagName("주택유형").item(0).getChildNodes();
//					code = eElement.getElementsByTagName("지역코드").item(0).getChildNodes();
//					cancelDay = eElement.getElementsByTagName("해제사유발생일").item(0).getChildNodes();
//					cancelReason = eElement.getElementsByTagName("해제여부").item(0).getChildNodes();
//				} catch (NullPointerException e) {
//
//				} finally {
//					//					거래금액
//					String dealAmountValue = null;
//					//					건축년도
//					String buildYearValue = null;
//					//					년
//					String yearValue = null;
//					//					대지면적
//					String areaValue = null;
//					//					법정동
//					String dongValue = null;
//					//					연면적
//					String floorAreaValue = null;
//					//					월
//					String monthValue = null;
//					//					일
//					String dayValue = null;
//					//					주택유형
//					String houseTypeValue = null;
//					//					지역코드
//					String codeValue = null;
//					//					해제사유 발생일
//					String cancelDayValue = null;
//					//					해제사유
//					String cancelReasonValue = null;
//
//
//					if (dealAmount != null) {
//						dealAmountValue = dealAmount.item(0).getNodeValue().trim();
//
//					}
//					if (buildYear != null) {
//						buildYearValue = buildYear.item(0).getNodeValue().trim();
//					}
//					if (year != null) {
//						yearValue = year.item(0).getNodeValue().trim();
//					}
//					if (area != null) {
//						areaValue = area.item(0).getNodeValue().trim();
//					}
//					if (dong != null) {
//						dongValue = dong.item(0).getNodeValue().trim();
//					}
//					if (floorArea != null) {
//						floorAreaValue = floorArea.item(0).getNodeValue().trim();
//					}
//					if (month != null) {
//						monthValue = month.item(0).getNodeValue().trim();
//					}
//					if (day != null) {
//						dayValue = day.item(0).getNodeValue().trim();
//					}
//					if (houseType != null) {
//						houseTypeValue = houseType.item(0).getNodeValue().trim();
//					}
//					if (code != null) {
//						codeValue = code.item(0).getNodeValue().trim();
//					}
//					if (cancelDay != null) {
//						cancelDayValue = cancelDay.item(0).getNodeValue().trim();
//					}
//					if (cancelReason != null) {
//						cancelReasonValue = cancelReason.item(0).getNodeValue().trim();
//					}
//					homeDto homeDto = new homeDto();
//					homeDto.setDealAmount(dealAmountValue);
//					homeDto.setBuildYear(buildYearValue);
//					homeDto.setYear(yearValue);
//					homeDto.setArea(floorAreaValue);
//					homeDto.setDong(dongValue);
//					homeDto.setFloorArea(floorAreaValue);
//					homeDto.setMonth(monthValue);
//					homeDto.setDay(dayValue);
//					homeDto.setHouseType(houseTypeValue);
//					homeDto.setCode(codeValue);
//					homeDto.setCancelDay(cancelDayValue);
//					homeDto.setCancelReason(cancelReasonValue);
//					
//					homeDaoImpl.gethomeDao().register(homeDto);;
//					
//				}
//
//			}
//		}
//	}
//
//}
