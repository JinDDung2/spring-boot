package com.example.hello.dao;

import com.example.hello.domain.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class hospitalDao {

    private final JdbcTemplate template;

    public void save(Hospital hospital) {
        String sql = "INSERT INTO nation_wide_hospitals(id, open_service_name, open_local_government_code, manegement_number, license_date, business_state, business_status_code, phone, full_address, road_name_address, hospital_name, business_type_name, healthcare_provider_count, patient_room_count, total_number_of_beds, total_area_size)" +
                "VALUES (?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?, ?, ?," +
                " ?)";
        template.update(sql, hospital.getId(), hospital.getOpenServiceName(), hospital.getOpenLocalGovernmentCode(),
                hospital.getManagementNumber(), hospital.getLicenseDate(), hospital.getBusinessStatus(),
                hospital.getBusinessStatusCode(), hospital.getPhone(), hospital.getFullAddress(),
                hospital.getRoadNameAddress(), hospital.getHospitalName(), hospital.getBusinessTypeName(),
                hospital.getHealthcareProviderCount(), hospital.getPatientRoomCount(), hospital.getTotalNumberOfBeds(),
                hospital.getTotalAreaSize());
    }

    /*public Hospital findById(String id) {
        String sql = "SELECT * FROM nation_wide_hospitals WHERE ORDER BY nation_wide_hospitals.id=?";
        return template.queryForObject(sql, rowMapper(), id);
    }

    private RowMapper<Hospital> rowMapper() {
        return (rs, rowNum) -> {
            Hospital hospital = new Hospital(rs.getInt("id"),
                    rs.getString("open_service_name"),
                    rs.getInt("open_local_government_code"),
                    rs.getString("management_number"),
                    rs.getTimestamp("license_date"),
                    rs.getInt("business_status"),
                    rs.getInt("business_status_code"),
                    rs.getString("phone"),
                    rs.getString("full_address"),
                    rs.getString("road_name_address"),
                    rs.getString("hospital_name"),
                    rs.getString("business_type_name"),
                    rs.getInt("healthcare_provider_count"),
                    rs.getInt("patient_room_count"),
                    rs.getInt("total_number_of_beds"),
                    rs.getFloat("total_area_size"));
            return hospital;
        };
    }*/

    public void deleteById(String id) {
        String sql = "DELETE FROM nation_wide_hospitals.id=?";
        template.update(sql, id);
    }
}
