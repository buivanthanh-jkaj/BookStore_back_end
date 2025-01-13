package jkai.book_store.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import jkai.book_store.Entity.NguoiDung;
import jkai.book_store.Entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public RepositoryRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // ID cho tất cả các entity
        config.exposeIdsFor(
                entityManager.getMetamodel().getEntities().stream()
                        .map(Type::getJavaType)
                        .toArray(Class[]::new)
        );

        // chi lay mot hoac 2 thang
//        config.exposeIdsFor(TheLoai.class, NguoiDung.class);

        // Cấu hình CORS
        cors.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Thay đổi domain tùy theo ứng dụng frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
