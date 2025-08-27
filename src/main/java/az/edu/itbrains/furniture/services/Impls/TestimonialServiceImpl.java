package az.edu.itbrains.furniture.services.Impls;

import az.edu.itbrains.furniture.dtos.testimonial.TestimonialDto;
import az.edu.itbrains.furniture.models.Testimonial;
import az.edu.itbrains.furniture.repositories.TestimonialRepository;
import az.edu.itbrains.furniture.services.TestimonialService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {
    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    public TestimonialServiceImpl(TestimonialRepository testimonialRepository, ModelMapper modelMapper) {
        this.testimonialRepository = testimonialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TestimonialDto> getAllTestimonial() {
        List<Testimonial> testimonialList=testimonialRepository.findAll();
        List<TestimonialDto>testimonialDtoList=testimonialList.stream().map(pro->modelMapper.map(pro, TestimonialDto.class)).collect(Collectors.toList());
        return testimonialDtoList;
    }
}
