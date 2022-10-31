package com.example.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Hospital {
    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", openServiceName='" + openServiceName + '\'' +
                ", openLocalGovernmentCode=" + openLocalGovernmentCode +
                ", managementNumber='" + managementNumber + '\'' +
                ", licenseDate=" + licenseDate +
                ", businessStatus=" + businessStatus +
                ", businessStatusCode=" + businessStatusCode +
                ", phone='" + phone + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", roadNameAddress='" + roadNameAddress + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", businessTypeName='" + businessTypeName + '\'' +
                ", healthcareProviderCount=" + healthcareProviderCount +
                ", patientRoomCount=" + patientRoomCount +
                ", totalNumberOfBeds=" + totalNumberOfBeds +
                ", totalAreaSize=" + totalAreaSize +
                '}';
    }
}
