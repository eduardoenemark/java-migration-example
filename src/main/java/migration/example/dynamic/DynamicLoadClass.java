package migration.example.dynamic;

import lombok.val;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.security.acl.Permission;
import java.util.Enumeration;
import java.util.SortedMap;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.Pack200;

public class DynamicLoadClass {

    public static void main(String... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        val entry = new java.security.acl.AclEntry() {
            @Override
            public boolean setPrincipal(Principal user) {
                return false;
            }

            @Override
            public Principal getPrincipal() {
                return null;
            }

            @Override
            public void setNegativePermissions() {

            }

            @Override
            public boolean isNegative() {
                return false;
            }

            @Override
            public boolean addPermission(Permission permission) {
                return false;
            }

            @Override
            public boolean removePermission(Permission permission) {
                return false;
            }

            @Override
            public boolean checkPermission(Permission permission) {
                return false;
            }

            @Override
            public Enumeration<Permission> permissions() {
                return null;
            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public Object clone() {
                return null;
            }
        };


        val base64 = new BASE64Encoder();
        base64.encode("OK".getBytes());

        val packer = new Pack200.Packer() {

            @Override
            public SortedMap<String, String> properties() {
                return null;
            }

            @Override
            public void pack(JarFile in, OutputStream out) throws IOException {

            }

            @Override
            public void pack(JarInputStream in, OutputStream out) throws IOException {

            }
        };
    }
}
