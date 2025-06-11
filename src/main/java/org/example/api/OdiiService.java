package org.example.api;

import org.springframework.stereotype.Service;

@Service
public class OdiiService {

    public String getThemeBasedList(int pageNo, int numOfRows, String langCode) {
        String serviceKey = "gPtV22mJezBSA5%2Bg8qhMQPCcx%2F8yr7SBcca0o4dmBLjzvpKuKfV%2FEwXTb%2Bq3Ps3buuhRP9sOlhqZSCSPMLoKzg%3D%3D";

        String url = "https://apis.data.go.kr/B551011/Odii/themeBasedList"
                + "?serviceKey=" + serviceKey
                + "&numOfRows=" + numOfRows
                + "&pageNo=" + pageNo
                + "&MobileOS=ETC"
                + "&MobileApp=TestApp"
                + "&langCode=" + langCode
                + "&_type=json";

        try {
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
            java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
                    .uri(java.net.URI.create(url))
                    .build();

            java.net.http.HttpResponse<String> response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());

            System.out.println("TourAPI Response status code: " + response.statusCode());
            System.out.println("TourAPI Response body: " + response.body());

            return response.body();

        } catch (Exception e) {
            System.err.println("TourAPI 호출 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
            return "{\"error\": \"TourAPI 호출 실패\", \"message\": \"" + e.getMessage() + "\"}";
        }
    }
}


