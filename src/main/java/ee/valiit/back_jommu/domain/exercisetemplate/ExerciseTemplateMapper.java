package ee.valiit.back_jommu.domain.exercisetemplate;

import ee.valiit.back_jommu.business.picture.PictureDto;
import ee.valiit.back_jommu.domain.exercise.ExerciseRequest;
import ee.valiit.back_jommu.domain.extempmusclegroup.ExTempMuscleGroupDto;
import ee.valiit.back_jommu.domain.musclegroup.MuscleGroup;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ExerciseTemplateMapper {

    @Mapping(source = "exerciseTemplateId", target = "id")
    ExerciseTemplate toExerciseTemplate(ExerciseRequest request);

    @Mapping(source = "id", target = "exerciseTempId")
    @Mapping(source = "name", target = "exerciseTempName")
    @Mapping(source = "imgData", target = "imgData", qualifiedByName = "byteArrayToString")
    ExerciseTemplateDto toTempDto(ExerciseTemplate exerciseTemplate);

    List<ExerciseTemplateDto> toTempDtos(List<ExerciseTemplate> templates);

    @Mapping(source = "id", target = "exerciseTempId")
    @Mapping(source = "imgData", target = "imgData", qualifiedByName = "byteArrayToString")
    PictureDto toPicDto(ExerciseTemplate exerciseTemplate);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] imgDataAsByteArray) {
        if (imgDataAsByteArray == null) {
            return null;
        }

        String imgDataAsString = new String(imgDataAsByteArray);
        return imgDataAsString;
    }
}
