package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;
    private TextView forgotPasswordTextView, createAccountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialisation des vues (vérifie bien que les IDs correspondent à ton layout XML)
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.button4);
        loadingProgressBar = findViewById(R.id.loading);
        forgotPasswordTextView = findViewById(R.id.textView);
        createAccountTextView = findViewById(R.id.textView4);

        // Bouton "Créer un compte"
        createAccountTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Bouton "Mot de passe oublié" (fonctionnalité à implémenter ou simple Toast)
        forgotPasswordTextView.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Fonctionnalité à implémenter", Toast.LENGTH_SHORT).show();
        });

        // Bouton de connexion avec vérification des identifiants
        loginButton.setOnClickListener(v -> {
            // Récupération des valeurs saisies
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            // Affichage de la barre de progression pendant la vérification
            loadingProgressBar.setVisibility(View.VISIBLE);

            // Attention : la vérification est sensible à la casse.
            // Exemple concret : identifiants attendus "abcd" et "EFGH" (ou adapte selon ton besoin)
            if (username.equals("abcd") && password.equals("efgh")) {
                // Redirection vers HabitatActivity avec passage des informations
                Intent intent = new Intent(LoginActivity.this, HabitatActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("PASSWORD", password);
                startActivity(intent);
            } else {
                // Affichage d'un message d'erreur si les identifiants sont incorrects
                Toast.makeText(LoginActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
            }

            // Masquer la barre de progression après vérification
            loadingProgressBar.setVisibility(View.GONE);
        });
    }
}
