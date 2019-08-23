package com.geekerstar.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

public class AclUtils {

	public static String getDigestUserPwd(String id) {
		String digest = "";
		try {
			digest = DigestAuthenticationProvider.generateDigest(id);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digest;
	}

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException, Exception {
		String id = "geekerstar:geekerstar";
		String idDigested = getDigestUserPwd(id);
		System.out.println(idDigested);
	}
}
