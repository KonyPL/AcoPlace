package put.poznan.AcoPlaceBackend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ImageStorage {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "announcementId", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Announcement announcement;
        @Column(columnDefinition="TEXT")
        private String b64image;
}
