package org.example.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.HospitalDetailItem;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HospitalDetailService {

    public HospitalDetailItem getHospitalDetail(String ykiho) {
        String serviceKey = "gPtV22mJezBSA5%2Bg8qhMQPCcx%2F8yr7SBcca0o4dmBLjzvpKuKfV%2FEwXTb%2Bq3Ps3buuhRP9sOlhqZSCSPMLoKzg%3D%3D";

        try {
            String url = "https://apis.data.go.kr/B551182/MadmDtlInfoService2.7/getDtlInfo2.7"
                    + "?serviceKey=" + serviceKey
                    + "&ykiho=" + ykiho
                    + "&_type=json";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("[응답코드] " + response.statusCode());
            System.out.println("[응답본문] " + response.body());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            JsonNode item = root.path("response").path("body").path("items").path("item");

            HospitalDetailItem detail = new HospitalDetailItem();
            detail.setYkiho(item.path("ykiho").asText());
            detail.setYadmNm(item.path("yadmNm").asText());
            detail.setAddr(item.path("addr").asText());
            detail.setTelno(item.path("telno").asText());
            detail.setHospUrl(item.path("hospUrl").asText());

            return detail;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
