package uz.shoxvlogs.shoxvlogs.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.shoxvlogs.shoxvlogs.intity.Fayl;
import uz.shoxvlogs.shoxvlogs.service.FaylService;

import java.io.*;
import java.time.LocalDate;

@RestController
@RequestMapping("api/fail")
@CrossOrigin(maxAge = 3600, value = "*")
public class FaylController {

    private final FaylService faylService;

    private final String ROOT_FOLDER = "image";


    public FaylController(FaylService faylService) {
        this.faylService = faylService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Fayl> upload(@RequestParam("fail") MultipartFile file) {
        Fayl f = new Fayl();
        f.setNom(file.getOriginalFilename());
        f.setLocalDate(LocalDate.now());

        f = faylService.create(f);

        System.out.println("Fayl nomi: " + f.getNom());
        System.out.println(file.getSize());

        try {
            File file1 = new File(ROOT_FOLDER);
            if (!file1.exists()) {
                file1.mkdirs();
            };

            file1 = new File(ROOT_FOLDER + File.separator + f.getId() + getKengaytma(file.getOriginalFilename()));

            file1.createNewFile();

            FileOutputStream fos = new FileOutputStream(file1);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            faylService.delete(f);
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(f);

    }

    @GetMapping("/download/{id}")
    public ResponseEntity<?> download(@PathVariable Long id) {
        Fayl f = faylService.getById(id).orElseThrow(() -> new RuntimeException("Not found"));

        File file = new File(ROOT_FOLDER + File.separator + f.getId() + getKengaytma(f.getNom()));

        if (file.exists()) {
            try {

                MediaType  mediaType = MediaTypeFactory.getMediaType(f.getNom()).orElse(MediaType.APPLICATION_OCTET_STREAM);

                ContentDisposition cd = ContentDisposition.
                        inline()
                        .filename(f.getNom())
                        .build();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(mediaType);
                headers.setContentDisposition(cd);

                return new ResponseEntity<>(new InputStreamResource(new FileInputStream(file)), headers, HttpStatus.OK);


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        throw new RuntimeException("Not found");
    }

    private String getKengaytma(String faylNom){
        if(faylNom != null && !faylNom.isEmpty()){
            return faylNom.substring(faylNom.lastIndexOf("."));
        }
        return "";
    }
}
