package uchuca.domain;

import org.springframework.core.io.Resource;

import java.util.List;

public class ImageResponse {

    private List<Resource> resources;

    public ImageResponse(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
