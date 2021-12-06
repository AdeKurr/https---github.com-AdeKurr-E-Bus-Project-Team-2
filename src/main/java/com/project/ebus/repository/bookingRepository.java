package com.project.ebus.repository;

import java.util.List;

import com.project.ebus.model.Booking;
import com.project.ebus.model.KeberangkatanDetail;
import com.project.ebus.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT keberangkatan.id, jurusan.deskripsi, keberangkatan.tanggal as waktu, bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga FROM keberangkatan INNER JOIN jurusan ON keberangkatan.id_jurusan = jurusan.id INNER JOIN bus ON keberangkatan.no_polisi = bus.no_polisi WHERE jurusan.deskripsi = ?1 AND keberangkatan.tanggal LIKE ?2% AND bus.kapasitas > (SELECT COUNT(*) FROM booking WHERE booking.id_keberangkatan = keberangkatan.id)", nativeQuery = true)
    List<KeberangkatanDetail> findBookingByTanggalAndKeberangkatan(String deskripsi, String tanggal);

    List<Booking> findByNik(user nik);

    @Query(value = "SELECT keberangkatan.id, jurusan.deskripsi, keberangkatan.tanggal as waktu, bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga FROM keberangkatan INNER JOIN jurusan ON keberangkatan.id_jurusan = jurusan.id INNER JOIN bus ON keberangkatan.no_polisi = bus.no_polisi WHERE jurusan.deskripsi = ?2 AND keberangkatan.tanggal LIKE ?1% AND bus.kapasitas > (SELECT COUNT(*) FROM booking WHERE booking.id_keberangkatan = keberangkatan.id)", nativeQuery = true)
    List<Booking> getBookingByTanggalAndDeskripsi(String tanggalanu, String deskripsianu);

}
