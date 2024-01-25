package tom.study.api.controller.light;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tom.study.api.controller.light.model.LightRequest;
import tom.study.api.usecase.light.ReadLightUsecase;
import tom.study.common.feign.resp.LightFeignResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LightController {
    private final ReadLightUsecase readLightUsecase;

    @GetMapping("/light")
    public List<LightFeignResponse> getLightTimingFeign(LightRequest lightRequest) {
        List<LightFeignResponse> response = readLightUsecase.execute(lightRequest);
        return response;
    }

}