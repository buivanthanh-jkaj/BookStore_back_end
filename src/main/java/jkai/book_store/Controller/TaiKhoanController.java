package jkai.book_store.Controller;

import jkai.book_store.Entity.NguoiDung;
import jkai.book_store.Services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtService jwtService;

    // Allow requests from 'http://localhost:3000'
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated @RequestBody NguoiDung nguoiDung){
        ResponseEntity<?> response = taiKhoanService.dangKyNguoiDung(nguoiDung);
        return response;
    }

//    @GetMapping("/kich-hoat")
//    public ResponseEntity<?> kichHoatTaiKhoan(@RequestParam String email, @RequestParam String maKichHoat){
//        ResponseEntity<?> response = taiKhoanService.kichHoatTaiKHoan(email, maKichHoat);
//        return response;
//    }

//    @PostMapping("/dang-nhap")
//    public ResponseEntity<?> dangNhap(@RequestBody LoginRequest loginRequest){
//        // Xác thực người dùng bằng tên đăng nhập và mật khẩu
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//            );
//            // Nếu xác thực thành công, tạo token JWT
//            if(authentication.isAuthenticated()){
//                final String jwt = jwtService.generateToken(loginRequest.getUsername());
//                return ResponseEntity.ok(new JwtResponse(jwt));
//            }
//        }catch (AuthenticationException e){
//            // Xác thực không thành công, trả về lỗi hoặc thông báo
//            return ResponseEntity.badRequest().body("Tên đăng nhập hặc mật khẩu không chính xác.");
//        }
//        return ResponseEntity.badRequest().body("Xác thực không thành công.");
//    }
}
