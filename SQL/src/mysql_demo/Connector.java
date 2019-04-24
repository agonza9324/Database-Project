package mysql_demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author nwilki3
 */
public class Connector {
    //Configuration parameters for the generation of the IAM Database Authentication token
  private static final String RDS_INSTANCE_HOSTNAME = "q68u8b2buodpme2n.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
  private static final int RDS_INSTANCE_PORT = 3306;
  private static final String DB_USER = "dufjcgoj84idkv1v";
  private static final String USER_PASS = "n0wvk18i1po7dubv";
  private static final String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME + ":" + RDS_INSTANCE_PORT;

  private static final String SSL_CERTIFICATE = "rds-combined-ca-bundle.pem";

  private static final String KEY_STORE_TYPE = "JKS";
  private static final String KEY_STORE_PROVIDER = "SUN";
  private static final String KEY_STORE_FILE_PREFIX = "sys-connect-via-ssl-test-cacerts";
  private static final String KEY_STORE_FILE_SUFFIX = ".jks";
  private static final String DEFAULT_KEY_STORE_PASSWORD = "changeit";

  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      throw new RuntimeException("connection is null, try calling createDBConnection() first");
    }

    return connection;
  }

  public static void createDBConnection() throws Exception {
    setSslProperties();
    connection = DriverManager.getConnection(JDBC_URL, setMySqlConnectionProperties());
    connection.setCatalog("lgghmk6nvkong10c");
  }

  /**
   * This method sets the mysql connection properties which includes the IAM Database Authentication token
   * as the password. It also specifies that SSL verification is required.
   * @return
   */
  private static Properties setMySqlConnectionProperties() {
    Properties mysqlConnectionProperties = new Properties();
    mysqlConnectionProperties.setProperty("verifyServerCertificate","true");
    mysqlConnectionProperties.setProperty("useSSL", "true");
    mysqlConnectionProperties.setProperty("user", DB_USER);
    mysqlConnectionProperties.setProperty("password", USER_PASS);
    return mysqlConnectionProperties;
  }

  /**
   * This method sets the SSL properties which specify the key store file, its type and password:
   * @throws Exception
   */
  private static void setSslProperties() throws Exception {
    System.setProperty("javax.net.ssl.trustStore", createKeyStoreFile());
    System.setProperty("javax.net.ssl.trustStoreType", KEY_STORE_TYPE);
    System.setProperty("javax.net.ssl.trustStorePassword", DEFAULT_KEY_STORE_PASSWORD);
  }

  /**
   * This method returns the path of the Key Store File needed for the SSL verification during the IAM Database Authentication to
   * the db instance.
   * @return
   * @throws Exception
   */
  private static String createKeyStoreFile() throws Exception {
    return createKeyStoreFile(createCertificate()).getPath();
  }

  /**
   *  This method generates the SSL certificate
   * @return
   * @throws Exception
   */
  private static X509Certificate createCertificate() throws Exception {
    CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
    URL url = new File(SSL_CERTIFICATE).toURI().toURL();
    if (url == null) {
      throw new Exception();
    }
    try (InputStream certInputStream = url.openStream()) {
      return (X509Certificate) certFactory.generateCertificate(certInputStream);
    }
  }

  /**
   * This method creates the Key Store File
   * @param rootX509Certificate - the SSL certificate to be stored in the KeyStore
   * @return
   * @throws Exception
   */
  private static File createKeyStoreFile(X509Certificate rootX509Certificate) throws Exception {
    File keyStoreFile = File.createTempFile(KEY_STORE_FILE_PREFIX, KEY_STORE_FILE_SUFFIX);
    try (FileOutputStream fos = new FileOutputStream(keyStoreFile.getPath())) {
      KeyStore ks = KeyStore.getInstance(KEY_STORE_TYPE, KEY_STORE_PROVIDER);
      ks.load(null);
      ks.setCertificateEntry("rootCaCertificate", rootX509Certificate);
      ks.store(fos, DEFAULT_KEY_STORE_PASSWORD.toCharArray());
    }
    return keyStoreFile;
  }

  /**
   * This method clears the SSL properties.
   * @throws Exception
   */
  private static void clearSslProperties() throws Exception {
    System.clearProperty("javax.net.ssl.trustStore");
    System.clearProperty("javax.net.ssl.trustStoreType");
    System.clearProperty("javax.net.ssl.trustStorePassword");
  }
}
