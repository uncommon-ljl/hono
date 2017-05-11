/**
 * Copyright (c) 2016 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial creation
 */
package org.eclipse.hono.config;

import java.util.Objects;

/**
 * Common properties required for creating/validating cryptographic signatures.
 *
 */
public class SignatureSupportingConfigProperties {

    private String sharedSecret;
    private String keyPath;
    private long tokenExpiration = 10L;
    private String certificatePath;

    /**
     * Gets the secret used for creating and validating HMAC based signatures.
     * 
     * @return The secret or {@code null} if not set.
     */
    public final String getSharedSecret() {
        return sharedSecret;
    }

    /**
     * Sets the secret to use for creating and validating HMAC based signatures.
     * 
     * @param secret The shared secret.
     * @throws NullPointerException if secret is {@code null}.
     */
    public final void setSharedSecret(final String secret) {
        this.sharedSecret = Objects.requireNonNull(secret);
    }

    /**
     * Sets the path to the file containing the private key to be used
     * for creating SHA256withRSA based signatures.
     * <p>
     * The file must be in PKCS8 PEM format.
     * 
     * @param keyPath The path to the PEM file.
     * @throws NullPointerException if the path is {@code null}.
     */
    public final void setKeyPath(final String keyPath) {
        this.keyPath = Objects.requireNonNull(keyPath);
    }

    /**
     * Gets the path to the file containing the private key to be used
     * for validating RSA based signatures.
     * 
     * @return The path to the file or {@code null} if not set.
     */
    public final String getKeyPath() {
        return keyPath;
    }

    /**
     * Gets the period of time after which tokens asserting the registration status of devices
     * expire.
     * 
     * @return The number of minutes after which tokens expire.
     */
    public final long getTokenExpiration() {
        return tokenExpiration;
    }

    /**
     * Sets the expiration period to use for tokens asserting the
     * registration status of devices.
     * <p>
     * The default value is 10 minutes.
     * 
     * @param minutes The number of minutes after which tokens expire.
     * @throws IllegalArgumentException if minutes is &lt;= 0.
     */
    public final void setTokenExpiration(final long minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("token expiration must be > 0");
        }
        this.tokenExpiration = minutes;
    }

    /**
     * Sets the path to the X.509 certificate containing the public key to be used
     * for validating SHA256withRSA based signatures.
     * <p>
     * The file must be in PKCS8 PEM format.
     * 
     * @param certPath The path to the PEM file.
     * @throws NullPointerException if the path is {@code null}.
     */
    public final void setCertificatePath(final String certPath) {
        this.certificatePath = Objects.requireNonNull(certPath);
    }

    /**
     * Gets the path to the X.509 certificate containing the public key to be used
     * for validating RSA based signatures.
     * 
     * @return The path to the file or {@code null} if not set.
     */
    public final String getCertificatePath() {
        return certificatePath;
    }
}