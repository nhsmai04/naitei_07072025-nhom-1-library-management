package org.librarymanagement.repository;

import org.librarymanagement.dto.response.BorrowRequestSummaryDto;
import org.librarymanagement.entity.BorrowRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRequestRepository extends JpaRepository<BorrowRequest, Integer> {
    @Query("""
        SELECT new org.librarymanagement.dto.response.BorrowRequestSummaryDto(
            br.id,
            u.username,
            br.quantity,
            br.createdAt,
            CASE 
                WHEN br.status = 0 THEN 'Đang chờ'
                WHEN br.status = 1 THEN 'Hoàn tất'
                WHEN br.status = 2 THEN 'Đã hủy'
                ELSE 'Không xác định'
            END
        )
        FROM BorrowRequest br
        JOIN br.user u
        WHERE (:status IS NULL OR br.status = :status)
    """)
    Page<BorrowRequestSummaryDto> findAllWithFilter(
            @Param("status") Integer status,
            Pageable pageable
    );
}
