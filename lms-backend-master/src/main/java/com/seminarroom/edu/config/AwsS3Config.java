    package com.seminarroom.edu.config;

    import com.amazonaws.auth.AWSStaticCredentialsProvider;
    import com.amazonaws.auth.BasicAWSCredentials;
    import com.amazonaws.services.s3.AmazonS3;
    import com.amazonaws.services.s3.AmazonS3ClientBuilder;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    public class AwsS3Config {

        // Use environment variables for security
        private static final String ACCESS_KEY = System.getenv("AWS_ACCESS_KEY_ID");
        private static final String SECRET_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");
        private static final String REGION = System.getenv("AWS_REGION") != null ? System.getenv("AWS_REGION") : "us-east-1";
        private static final String BUCKET_NAME = System.getenv("AWS_S3_BUCKET_NAME") != null ? System.getenv("AWS_S3_BUCKET_NAME") : "seminarroom-files";

        @Bean
        public AmazonS3 amazonS3() {
            BasicAWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
            return AmazonS3ClientBuilder.standard()
                    .withRegion(REGION)
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .build();
        }

        @Bean
        public String bucketName() {
            return BUCKET_NAME;
        }
    }
