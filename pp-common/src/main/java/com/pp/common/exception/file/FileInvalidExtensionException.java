package com.pp.common.exception.file;

import org.apache.tomcat.util.http.fileupload.FileUploadException;

import java.util.Arrays;

/**
 * 文件上传 误异常类
 *
 * @author ruoyi
 */
public class FileInvalidExtensionException extends FileUploadException {
    private static final long serialVersionUID = 1L;

    private String[] allowedExtension;
    private String extension;
    private String filename;

    public FileInvalidExtensionException(String[] allowedExtension, String extension, String filename) {
        super("filename : [" + filename + "], extension : [" + extension + "], allowed extension : [" + Arrays.toString(allowedExtension) + "]");
        this.allowedExtension = allowedExtension;
        this.extension = extension;
        this.filename = filename;
    }

    public String[] getAllowedExtension() {
        return allowedExtension;
    }

    public String getExtension() {
        return extension;
    }

    public String getFilename() {
        return filename;
    }

    public static class FileInvalidImageExtensionException extends FileInvalidExtensionException {
        private static final long serialVersionUID = 1L;

        public FileInvalidImageExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

    public static class FileInvalidFlashExtensionException extends FileInvalidExtensionException {
        private static final long serialVersionUID = 1L;

        public FileInvalidFlashExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

    public static class FileInvalidMediaExtensionException extends FileInvalidExtensionException {
        private static final long serialVersionUID = 1L;

        public FileInvalidMediaExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }

    public static class FileInvalidVideoExtensionException extends FileInvalidExtensionException {
        private static final long serialVersionUID = 1L;

        public FileInvalidVideoExtensionException(String[] allowedExtension, String extension, String filename) {
            super(allowedExtension, extension, filename);
        }
    }
}
