package com.suhang.movie.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.suhang.movie.model.User;

/**
 * @author hang.su
 * @since 2017-04-25 下午8:57
 */
@Service("passwordService")
public class PasswordServiceImpl implements PasswordService {

    private String algorithmName = "SHA-256";

    private int hashIterations = 10000;

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Override
    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        Hash hash = new SimpleHash(
            algorithmName,
            user.getPassword(),
            ByteSource.Util.bytes(user.getCredentialsSalt()),
            hashIterations);
        user.setPassword(hash.toHex());
    }

    @Override
    public boolean passwordMatches(String plaintext, User user) {
        Hash computed = new SimpleHash(algorithmName,
            plaintext,
            ByteSource.Util.bytes(user.getCredentialsSalt()),
            hashIterations);
        return computed.equals(Sha256Hash.fromHexString(user.getPassword()));
    }
}
