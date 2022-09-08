package uz.pdp.codingbat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.codingbat.entity.Language;
import uz.pdp.codingbat.exception.InputDataExistsException;
import uz.pdp.codingbat.payload.ApiResult;
import uz.pdp.codingbat.payload.LanguageDTO;
import uz.pdp.codingbat.repository.LanguageRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private LanguageRepository languageRepository;

    @Override
    public ApiResult add(LanguageDTO languageDTO) {

        if (languageRepository.existsByTitle(languageDTO.getTitle()))
            throw new InputDataExistsException("BUnday til mavhjud");

        Language language = new Language(languageDTO.getTitle());

        languageRepository.save(language);

        return new ApiResult(true, "OK okasi");
    }

    @Override
    public List<LanguageDTO> getAll() {
        return languageRepository.findAll()
                .stream().map(this::mapLanguageToLanguageDTO).collect(Collectors.toList());
    }

    @Override
    public LanguageDTO get(Integer id) {
        Language language = languageRepository.findById(id).orElseThrow(RuntimeException::new);
        return mapLanguageToLanguageDTO(language);
    }

    @Override
    public ApiResult edit(Integer id, LanguageDTO languageDTO) {
        return new ApiResult();
    }

    @Override
    public ApiResult delete(Integer id) {
        Optional<Language> byId = languageRepository.findById(id);
        if (byId.isEmpty()) throw new InputDataExistsException("Bunday language Mavjud emas!");

        languageRepository.delete(byId.get());
        return new ApiResult(true, "OK");
    }

    private LanguageDTO mapLanguageToLanguageDTO(Language language) {
        return new LanguageDTO(language.getId(), language.getTitle(), language.getUrl());
    }
}
