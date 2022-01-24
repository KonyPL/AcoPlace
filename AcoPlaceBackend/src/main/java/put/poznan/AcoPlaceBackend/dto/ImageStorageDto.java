package put.poznan.AcoPlaceBackend.dto;

import lombok.*;
import put.poznan.AcoPlaceBackend.model.ImageStorage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ImageStorageDto {
    @EqualsAndHashCode.Include
    private Integer id;
    private Integer announcementId;
    private String b64image;

    public ImageStorageDto makeFromModel(ImageStorage imageStorage){
        this.id = imageStorage.getId();
        this.announcementId = imageStorage.getAnnouncement().getId();
        this.b64image = imageStorage.getB64image();

        return this;
    }
}

