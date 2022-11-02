package com.example.hello.domain.dto;

import com.example.hello.domain.Hospital;
import lombok.Getter;

@Getter
public class HospitalResponseDto {
    // 1병원 이름, 2주소, 3도로명주소, 4의료진 수, 5병상 수, 6면적, 7폐업여부
    private String hospitalName;
    private String fullAddress;
    private String roadNameAddress;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private float totalAreaSize;

    public HospitalResponseDto from(Hospital hospital) {
        HospitalResponseDto dto = new HospitalResponseDto();
        dto.hospitalName = hospital.getHospitalName();
        dto.fullAddress = hospital.getFullAddress();
        dto.roadNameAddress = hospital.getRoadNameAddress();
        dto.healthcareProviderCount = hospital.getHealthcareProviderCount();
        dto.patientRoomCount = hospital.getPatientRoomCount();
        dto.totalAreaSize = hospital.getTotalAreaSize();
        return dto;
    }
}
