package lv.nixx.poc.second.service;

public class CustomService {

    private final String serviceProcessor;

    public CustomService(String serviceProcessor) {
        this.serviceProcessor = serviceProcessor;
    }

    public String process(String param) {
        return serviceProcessor + ":" + param + ":" + System.currentTimeMillis();
    }

}
