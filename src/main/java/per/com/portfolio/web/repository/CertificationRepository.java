package per.com.portfolio.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import per.com.portfolio.web.domain.Certificate;

import java.util.UUID;

@Repository
public interface CertificationRepository extends JpaRepository<Certificate, UUID> {
}

