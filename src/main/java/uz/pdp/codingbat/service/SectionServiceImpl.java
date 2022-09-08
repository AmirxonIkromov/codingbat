package uz.pdp.codingbat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.entity.Section;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.SectionDTO;
import uz.pdp.codingbat.repository.LanguageRepository;
import uz.pdp.codingbat.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;

    private final LanguageRepository languageRepository;

    @Override
    public ApiResult add(SectionDTO sectionDTO) {
        sectionRepository.save(mapSectionDTOToSection(sectionDTO,new Section(),languageRepository.findById(sectionDTO.getLanguage_id()).orElseThrow(IllegalStateException::new)));
        return new ApiResult(true,"success");
    }

    @Override
    public List<SectionDTO> getAll() {
        return sectionRepository.findAll()
                .stream()
                .map(section -> new SectionDTO(section.getId(),
                        section.getTitle(),section.getUrl(),section.getMaxRate(),section.getDescription(),section.getLanguage().getId()))
                .toList();
    }

    @Override
    public SectionDTO get(Integer id) {
        Section section = sectionRepository.findById(id).orElseThrow(IllegalStateException::new);
        return new SectionDTO(section.getId(),section.getTitle(),section.getUrl(),section.getLanguage().getId(),section.getMaxRate(),section.getDescription());
    }

    @Override
    public ApiResult edit(Integer id, SectionDTO sectionDTO) {
        Language language = languageRepository.findById(sectionDTO.getLanguage_id()).orElseThrow(IllegalStateException::new);
        Section section = sectionRepository.findById(id).orElseThrow(IllegalStateException::new);
        sectionRepository.save(mapSectionDTOToSection(sectionDTO,section,language));
        return new ApiResult(true,"success");
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<Section> byId = sectionRepository.findById(id);
        if (byId.isEmpty()) throw new InputDataExistsException("Bunday section Mavjud emas!");

        sectionRepository.delete(byId.get());
        return new ApiResult(true, "OK");
    }

    private Section mapSectionDTOToSection(SectionDTO sectionDTO,Section section,Language language) {
        section.setTitle(sectionDTO.getTitle());
        section.setUrl(sectionDTO.getUrl());
        section.setMaxRate(sectionDTO.getMaxRate());
        section.setDescription(sectionDTO.getDescription());
        section.setLanguage(language);
        return section;
    }
}
