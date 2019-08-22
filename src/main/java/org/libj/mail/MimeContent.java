/* Copyright (c) 2016 LibJ
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.libj.mail;

import java.io.Serializable;
import java.util.Objects;

/**
 * The {@code MimeContent} represents message content with an associated mime
 * type.
 */
public class MimeContent implements Cloneable, Serializable {
  private static final long serialVersionUID = -51968810703836463L;
  private final String content;
  private final String type;

  /**
   * Creates a new {@code MimeContent} with the provided {@code content} and
   * mime {@code type}.
   *
   * @param content The content string.
   * @param type The mime type string.
   * @throws NullPointerException If {@code content} or {@code type} is null.
   */
  public MimeContent(final String content, final String type) {
    this.content = Objects.requireNonNull(content);
    this.type = Objects.requireNonNull(type);
  }

  /**
   * @return The content string.
   */
  public String getContent() {
    return content;
  }

  /**
   * @return The type string.
   */
  public String getType() {
    return type;
  }

  @Override
  public MimeContent clone() {
    try {
      return (MimeContent)super.clone();
    }
    catch (final CloneNotSupportedException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  public int hashCode() {
    return content.hashCode() ^ type.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this)
      return true;

    if (!(obj instanceof MimeContent))
      return false;

    final MimeContent that = (MimeContent)obj;
    return content.equals(that.content) && type.equals(that.type);
  }
}