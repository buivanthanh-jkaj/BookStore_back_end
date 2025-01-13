package jkai.book_store.Services;


import jkai.book_store.Entity.NguoiDung;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);

}