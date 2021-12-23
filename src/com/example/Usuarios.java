package com.example;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

public class Usuarios {
    ArrayList<Usuario> usuarios = new ArrayList();

    public Usuarios() {}

    public void listarUsuarios() {
        for(Usuario usuario : usuarios)
            System.out.println(usuario.toString());
    }

    /* ----------- REGSITRO ------------ */
    public boolean registrar(String correoElectronico, String contrasena, String nombreCompleto) {
        if(correoElectronicoExiste(correoElectronico))
            return false;
        else {
            try {
                int iterations = 1000;
                char[] chars = contrasena.toCharArray();
                byte[] salt = getSalt();

                PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);

                SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                byte[] hash = skf.generateSecret(spec).getEncoded();
                usuarios.add(new Usuario(correoElectronico, iterations + ":" + toHex(salt) + ":" + toHex(hash), nombreCompleto));
            } catch(NoSuchAlgorithmException e) {
                System.out.println("Error: " + e.getMessage());
            } catch(InvalidKeySpecException e) {
                System.out.println("Error: " + e.getMessage());
            }
            return true;
        }
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    /* ----------- LOGIN --------- */

    public int acceso(String correoElectronico, String contrasena) {
        try {
            if(!correoElectronicoExiste(correoElectronico))
                return -1;

            for(int i=0; i<usuarios.size(); i++) {
                if(usuarios.get(i).getContrasena() != null)
                    if(correoElectronico.equalsIgnoreCase(usuarios.get(i).getCorreoElectronico()) &&
                            contrasenaCorrecta(usuarios.get(i).getContrasena(), contrasena)) {
                        return 1;
                    }
            }
        } catch(NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException: " + e.getMessage());
        } catch (InvalidKeySpecException e) {
            System.out.println("InvalidKeySpecException: " + e.getMessage());
        }
        return -2;
    }

    public boolean contrasenaCorrecta(String contrasena1, String contrasena2) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        try {
            String[] parts = contrasena1.split(":");
            int iterations = Integer.parseInt(parts[0]);
            byte[] salt = fromHex(parts[1]);
            byte[] hash = fromHex(parts[2]);
            PBEKeySpec spec = new PBEKeySpec(contrasena2.toCharArray(), salt, iterations, hash.length * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] testHash = skf.generateSecret(spec).getEncoded();
            int diff = hash.length ^ testHash.length;
            for(int i = 0; i < hash.length && i < testHash.length; i++) {
                diff |= hash[i] ^ testHash[i];
            }
            return diff == 0;
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
            return false;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
            return false;
        }
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++) {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }

    public boolean correoElectronicoExiste(String correoElectronico) {
        for(int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getCorreoElectronico().equalsIgnoreCase(correoElectronico))
                return true;
        }
        return false;
    }
}
