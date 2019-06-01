package net.lightwing.qyshm_web.commons.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("file")
public class FileController
{
    @RequestMapping("upload")
    public Map<String,Object> editorUpload(@RequestParam("files") MultipartFile[] files)
    {
        try
        {
            List<String> uploadPath = new ArrayList<>();
            for(MultipartFile file:files)
            {
                if(StringUtils.isNotBlank(file.getOriginalFilename()))
                {
                    Map<String, Object> upload = UPLOAD.UPLOADFILE(file);
                    if((int)upload.get("code")== 200)
                    {
                        uploadPath.add(Constant.DOMAIN+"/pictures/"+upload.get("filename"));
                    }
                }
            }
            return MessageBack.uploadSuccess(0,"文件上传成功",uploadPath);
        }
        catch (Exception e)
        {
//            log.warn("[UploadController_uploadFile():文件上传错误信息:]"+e.getMessage());
            return MessageBack.uploadFailed(500,"文件上传失败");
        }

    }
}
