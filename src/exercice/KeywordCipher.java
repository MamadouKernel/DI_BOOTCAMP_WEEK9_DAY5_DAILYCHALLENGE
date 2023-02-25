package exercice;

import java.util.*;

public class KeywordCipher {
    
    // Méthode pour générer l'alphabet chiffré à partir d'un mot-clé donné
    public static String generateCipherAlphabet(String keyword) {
        String cipherAlphabet = "";
        keyword = keyword.toUpperCase().replaceAll("[^A-Z]", ""); // Convertir le mot-clé en majuscules et supprimer les caractères non alphabétiques
        Set<Character> set = new HashSet<Character>();
        for (char c : keyword.toCharArray()) {
            if (!set.contains(c)) { // Éliminer les doublons
                set.add(c);
                cipherAlphabet += c;
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!set.contains(c)) { // Ajouter les lettres restantes dans l'ordre alphabétique
                cipherAlphabet += c;
            }
        }
        return cipherAlphabet;
    }
    
    // Méthode pour chiffrer le message en utilisant l'alphabet chiffré généré à partir du mot-clé
    public static String encrypt(String plaintext, String keyword) {
        String ciphertext = "";
        String cipherAlphabet = generateCipherAlphabet(keyword);
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", ""); // Convertir le texte en majuscules et supprimer les caractères non alphabétiques
        for (char c : plaintext.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { // Chiffrer uniquement les lettres
                ciphertext += cipherAlphabet.charAt(c - 'A');
            } else { // Ajouter les caractères spéciaux et les espaces tels quels
                ciphertext += c;
            }
        }
        return ciphertext;
    }
    
    // Méthode pour déchiffrer le message en utilisant l'alphabet chiffré généré à partir du mot-clé
    public static String decrypt(String ciphertext, String keyword) {
        String plaintext = "";
        String cipherAlphabet = generateCipherAlphabet(keyword);
        ciphertext = ciphertext.toUpperCase();
        for (char c : ciphertext.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { // Déchiffrer uniquement les lettres
                plaintext += (char) ('A' + cipherAlphabet.indexOf(c));
            } else { // Ajouter les caractères spéciaux et les espaces tels quels
                plaintext += c;
            }
        }
        return plaintext;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Keyword : ");
        String keyword = input.nextLine();
        System.out.print("Message : ");
        String plaintext = input.nextLine();
        
        String ciphertext = encrypt(plaintext, keyword);
        System.out.println("Ciphered String : " + ciphertext);
        
        String decryptedtext = decrypt(ciphertext, keyword);
        System.out.println("Deciphered String : " + decryptedtext);
    }
}
