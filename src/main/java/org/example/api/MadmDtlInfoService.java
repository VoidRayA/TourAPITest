package org.example.api;

import org.springframework.stereotype.Service;

@Service
public class MadmDtlInfoService {
    public String getDtlInfo(String ykiho, int pageNo, int numOfRows) {
        String serviceKey = "gPtV22mJezBSA5%2Bg8qhMQPCcx%2F8yr7SBcca0o4dmBLjzvpKuKfV%2FEwXTb%2Bq3Ps3buuhRP9sOlhqZSCSPMLoKzg%3D%3D";

        String url = "https://apis.data.go.kr/B551182/MadmDtlInfoService2.7"
                + "?serviceKey=" + serviceKey
                + "&ykiho=" + ykiho
                + "&numOfRows=" + numOfRows
                + "&pageNo=" + pageNo
                + "&_type=json";

        try {
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
                    .build();

            java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

            System.out.println("응답코드 : " + response.statusCode());
            System.out.println("응답본문 : " + response.body());

            return response.body();

        } catch (Exception e) {
            System.err.println("의료기관별상세정보서비스 호출 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
            return "{\"error\": \"API 호출 실패\", \"message\": \"" + e.getMessage() + "\"}";
        }
    }
}
