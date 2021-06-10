package net.skhu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class MemberActivity extends AppCompatActivity {

    private static String TAG = "MemberinitActivity";
    private FirebaseAuth mFirebaseAuth;
    private EditText nameEditText, phoneNumberEditText, birthDayEditText, addressEditText;
    private Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        mFirebaseAuth = FirebaseAuth.getInstance();
        nameEditText = findViewById(R.id.nameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        birthDayEditText = findViewById(R.id.birthDayEditText);
        addressEditText = findViewById(R.id.addressEditText);

        Button btn_check = findViewById(R.id.checkButton);
        btn_check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = nameEditText.getText().toString();
                String phone = phoneNumberEditText.getText().toString();
                String birth = birthDayEditText.getText().toString();
                String add = addressEditText.getText().toString();

                if (name.length() > 0 && phone.length() > 9 && birth.length() > 5 && add.length() > 0) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    FirebaseFirestore db = FirebaseFirestore.getInstance();

                    MemberInfo memberInfo = new MemberInfo(name, phone, birth, add);
                    if (user != null) {
                        db.collection("users").document(user.getUid()).set(memberInfo)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(MemberActivity.this, "회원정보 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MemberActivity.this, "회원정보 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        Toast.makeText(MemberActivity.this, "사용자 정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}